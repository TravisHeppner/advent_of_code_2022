(ns advent-of-code-2022.day-03
  (:require
    [clojure.string :as cs]
    [advent-of-code-2022.utils :refer :all]
    [clojure.set :as set]))

(def input (read-prompt "day_03.txt"))

(defn half-split [s]
  (let [l (/ (count s) 2)]
    (map cs/join
         [(take l s) (take-last l s)])))

(defn parse-input [input-string]
  (->> input-string
       cs/split-lines))

(defn find-overlap [[s1 s2]]
  (first (set/intersection (set s1) (set s2))))

(defn value [c]
  (if (re-find #"[a-z]" (str c))
    (- (int c) 96)
    (- (int c) 38)))

;(println "a-z :  " (value \a) "-" (value \z))
;(println "A-Z :" (value \A) "-" (value \Z))


(def part-1
  (->>
    (parse-input input)
    (map (comp value find-overlap half-split))
    (reduce +)))
(println "part1:" part-1)


(def part-2
  (->>
    (parse-input input)
    (partition-all 3)
    (map #(->> (map set %)
               (apply set/intersection)
               first
               value))
    (reduce +)))
(println "part2:" part-2)