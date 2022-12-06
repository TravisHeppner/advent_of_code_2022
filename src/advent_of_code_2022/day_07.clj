(ns advent-of-code-2022.day-07
  (:require
    [clojure.string :as cs]
    [advent-of-code-2022.utils :refer :all]))

(def input (read-prompt "day_07_sample.txt"))
;(def input (read-prompt "day_07.txt"))

(defn parse-input [input-string]
  (->> input-string
       cs/split-lines))


(def part-1
  (->>
    (parse-input input)))
(println "part1:" part-1)


(def part-2
  (->>
    (parse-input input)))
(println "part2:" part-2)