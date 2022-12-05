(ns advent-of-code-2022.day-05
  (:require
    [clojure.string :as cs]
    [advent-of-code-2022.utils :refer :all]))

(def input (read-prompt "day_05_sample.txt"))
;(def input (read-prompt "day_05.txt"))

(defn transpose
  "transposes a matrix, while filling in any missing spots with the filler (nil by default)"
  ([matrix] (transpose nil matrix))
  ([filler matrix]
   (let [max_y (count matrix)
         max_x (apply max (map count matrix))]
     (mapv (fn [x] (mapv (fn [y] (get-in matrix [y x] filler)) (range max_y))) (range max_x)))))

(defn parse-input [input-string]
  (let [[crates instructions] (split-on-blank input-string)]
    {:crates       (->> crates
                        cs/split-lines
                        (mapv (fn [line] (->> line
                                              (partition-all 4)
                                              (mapv second))))
                        transpose
                        (mapv #(drop-last (drop-while #{\space} %))))
     :instructions (->> (cs/split-lines instructions)
                        (map (fn [s] (->> (re-find #"move (\d+) from (\d+) to (\d+)" s)
                                          rest
                                          (map read-string)))))}))


(defn step-fn [move-order]
  (fn [state]
    (if-let [instructions (first (:instructions state))]
      (let [[num start end] instructions
            moved (move-order (take num (get-in state [:crates (dec start)])))]
        (-> state
            (update-in [:crates (dec start)] #(drop num %))
            (update-in [:crates (dec end)] #(concat moved %))
            (update :instructions rest)))
      (assoc state :done? true))))


(def part-1
  (->>
    (parse-input input)
    (iterate (step-fn reverse))
    (take-while (comp not :done?))
    last
    :crates
    (map first)
    (apply str)))
(println "part1:" part-1)

(def part-2
  (->>
    (parse-input input)
    (iterate (step-fn identity))
    (take-while (comp not :done?))
    last
    :crates
    (map first)
    (apply str)))
(println "part2:" part-2)