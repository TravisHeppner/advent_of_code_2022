(ns advent-of-code-2022.day-01
  (:require
    [clojure.string :as cs]
    [advent-of-code-2022.utils :as utils]))

(def input (utils/read-prompt "day_01.txt"))

(defn parse-input [input-string]
  (->> (cs/split input-string #"(\r?\n){2}") ;split on double newline.  Carriage return for dumb windows.
       (map #(map read-string (cs/split-lines %)))))

(comment
  (parse-input input))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def solution-01-1
  (->> (parse-input input)
       (map #(apply + %))
       (apply max)))

(println "part1: " solution-01-1)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def solution-01-2
  (->> (parse-input input)
       (map #(apply + %))
       sort
       (take-last 3)
       (apply +)))

(println "part2: " solution-01-2)