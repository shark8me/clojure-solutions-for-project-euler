(ns problem20 (:use clojure.test))

(defn soln20 []
  (apply + (map #(. Integer parseInt %) (rest (seq (. (str (apply * (range 100 0 -1))) split ""))))))

(is (= 648 (soln20)))

