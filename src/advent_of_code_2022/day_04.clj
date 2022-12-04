(ns advent-of-code-2022.day-04
  (:require
    [clojure.string :as cs]
    [advent-of-code-2022.utils :refer :all]))

;(def input (read-prompt "day_04_sample.txt"))
(def input (read-prompt "day_04.txt"))

(defn parse-input [input-string]
  (->> input-string
            cs/split-lines
            (map #(->> (re-find #"(\d+)-(\d+),(\d+)-(\d+)" %)
                       rest
                       (map read-string)))))


(def part-1
  (->>
    (parse-input input)
    (filter (fn [[a1 a2 b1 b2]]
              (or (<= a1 b1 b2 a2)
                  (<= b1 a1 a2 b2))))
    count))
(println "part1:" part-1)


(def part-2
  (->>
    (parse-input input)
    (filter (fn [[a1 a2 b1 b2]]
              (or (<= a1 b2 a2)
                  (<= b1 a2 b2)
                  (<= a1 b1 a2)
                  (<= b1 a1 b2))))
    count))
(println "part2:" part-2)