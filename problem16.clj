(ns problem16 (:use clojure.test))

;simple one liner

(defn sumOfDigits [nthpower]
     (apply + (map #(. Integer parseInt %) (rest (. (str (last (take nthpower (iterate #(* 2 %) 2)))) split "")))))

(is (= 1366 (sumOfDigits 1000)))

