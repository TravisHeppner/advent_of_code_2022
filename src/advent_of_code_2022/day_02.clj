(ns advent-of-code-2022.day-02
  (:require
    [clojure.string :as cs]
    [advent-of-code-2022.utils :as utils]))

(def input (utils/read-prompt "day_02.txt"))

(defn parse-input [input-string]
  (->> (cs/split input-string #"(\r?\n){2}")
       (map #(map read-string (cs/split-lines %)))))