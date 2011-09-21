(ns problem35)

(use '[clojure.contrib.lazy-seqs :only (primes)])
(use '[clojure.string :only (join)])


(defn rotatenum [n]
  (let [start (rest (. (str n) split  ""))]
    (. Integer parseInt (clojure.string/join (cons (last start) (butlast start) )))))

(defn allr [n]
  (let [c (count (rest (. (str n) split "")))]
    (take c (iterate rotatenum n))))


(def nprimes (take-while #(> 1000000 %) primes))

(def sprimes (set nprimes))

(defn allrsareprimes [n]
  (every? #(sprimes %) (allr n)))

(defn soln35 [] 
  (count (filter allrsareprimes nprimes)))