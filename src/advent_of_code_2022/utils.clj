(ns advent-of-code-2022.utils
  (:require [clojure.java.io :as io]
            [clojure.string :as cs]))

(defn read-prompt [day]
    (slurp  (io/resource day)))

(defn split-on-blank [s]
  (cs/split s #"(\r?\n){2}"))


(defmacro print-and-return
  ([x]
   `(let [x# ~x]
      (println x#) x#))
  ([flag x]
   `(let [flag# '~flag
          space# (cs/join (repeat (max (- 40 (count (str flag#)))) " "))
          x# ~x]
      (println "  " flag# space# x#)
      x#)))

(defmacro with-separator [op & body]
  `(do
     (println)
     (println (str "(" ~op))
     (let [x# (do ~@body)]
       (println ")")
       x#)))


(defmacro debug-> [ & args]
  "to see the values that are getting passed during the chaining .. it gets printed immediately without
  waiting for the rest of the chain to execute. Could be usefull in case one of the following functions
  throws an exception."
  `(with-separator "->"
     (-> ~@(interleave args
                       (map (fn [x] `((fn [k#] (print-and-return ~x k#)))) args)))))



(defmacro debug->> [& args]
  "to see the values that are getting passed during the chaining .. it gets printed immediately without
  waiting for the rest of the chain to execute. Could be usefull in case one of the following functions
  throws an exception."
  `(with-separator "->>"
     (->> ~@(interleave args
                        (map (fn [x] (list 'print-and-return x)) args)))))


(comment
  (debug->> 1
            (+ 2)
            (- 3))
  (debug-> 1
           (+ 2)
           (- 3)))


