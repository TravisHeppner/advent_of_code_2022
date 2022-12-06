(ns advent-of-code-2022.day-06
  (:require
    [advent-of-code-2022.utils :refer :all]))

;(def input (read-prompt "day_06_sample.txt"))
(def input (read-prompt "day_06.txt"))


(def part-1
  (->> input
       (partition 4 1)
       (take-while #(> 4 (count (set %))))
       count
       (+ 4)))
(println "part1:" part-1)

(def part-2
  (->> input
       (partition 14 1)
       (take-while #(> 14 (count (set %))))
       count
       (+ 14)))
(println "part2:" part-2)