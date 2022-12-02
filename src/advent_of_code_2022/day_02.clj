(ns advent-of-code-2022.day-02
  (:require
    [clojure.string :as cs]
    [advent-of-code-2022.utils :as utils]))

(def input (utils/read-prompt "day_02.txt"))

(def translate
  {"A" 1 "X" 1 "Y" 2 "B" 2 "Z" 3 "C" 3})

(defn parse-input [input-string]
  (->> input-string
       cs/split-lines
       (map #(map translate (cs/split % #" ")))))


(defn score [[them me]]
  (+ me
     (cond
       (= them  me) 3
       (= (mod them 3) (mod (dec me) 3)) 6
       :default 0)))
(let [sample (parse-input "A Y\nB X\nC Z")
      matches (map score sample)
      total (reduce + matches)]
  (println "sample score: " matches " -> "total))

(def part1
  (->> input
       parse-input
       (map score)
       (reduce +)))
(println "part1 ->" part1)

(defn match-res [[them result]]
  [them
   (case result
     1 (inc (mod (dec (dec them)) 3))
     2 them
     3 (inc (mod them 3)))])


(let [sample (parse-input "A Y\nB X\nC Z")
      matches (map (comp score match-res) sample)
      total (reduce + matches)]
  (println "sample score: " matches " -> "total))


(def part2
  (->> input
       parse-input
       (map (comp score match-res))
       (reduce +)))
(println "part2 ->" part2)

