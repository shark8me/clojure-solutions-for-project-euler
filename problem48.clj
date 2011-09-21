(ns problem48 
 )

 (use '[clojure.contrib.math :only (expt)])
 
 
 (take-last 10 (rest (. (str (apply + ( map #(expt % %) (range 1 1001)))) split "")))
 