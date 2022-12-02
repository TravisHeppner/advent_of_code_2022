(ns advent-of-code-2022.utils
  (:require [clojure.java.io :as io]
            [clojure.string :as cs]))

(defn read-prompt [day]
    (slurp  (io/resource day)))

(defn split-on-blank [s]
  (cs/split s #"(\r?\n){2}"))