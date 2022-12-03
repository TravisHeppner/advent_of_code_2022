(ns advent-of-code-2022.day-04
  (:require
    [clojure.string :as cs]
    [advent-of-code-2022.utils :refer :all]
    [clojure.set :as set]))

(def input (read-prompt "day_04_sample.txt"))

(defn parse-input [input-string]
  (->> input-string
       cs/split-lines))


(def part-1
  (debug->>
    (parse-input input)))
(println "part1:" part-1)


(def part-2
  (debug->>
    (parse-input input)))
(println "part2:" part-2)