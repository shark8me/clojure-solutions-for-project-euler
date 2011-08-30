(ns simple  
  (:require clojure.contrib.math))

(def mult (fn [x y] (* x y)))

(mult 5 10)

#problem 6
(defn sumofsquares [num] (apply + (map #(* % %) (range 1 num))))

(defn squareofsum [num] (let [sum (apply + (range 1 num))] (* sum sum)))

(- (squareofsum 101) (sumofsquares 101))

#problem 5
(defn isprime [num] (empty? (filter #(not %) (map #(not (zero? (mod num %))) (range 2 num)))))

(defn isdivisibleby [num]
                       (let [nums (range 2 21)]
                         (every? #(zero? (mod num %)) nums)))
#'simple/isdivisibleby
(take 1 (filter isdivisibleby (iterate #(+ 20 %) 20)))

#problem 3

(defn isprime [num]
        (let [till (int (Math/sqrt num))]
          (every? #(not (zero? (mod num %))) (range 3 (+ 1 till) 2))))

#(last (filter isprime (range 2 600851475143)))
#
(use '[clojure.contrib.lazy-seqs :only (primes)])
(defn divby [num divisor]
     (if (zero? (rem num divisor)) (divby (/ num divisor) divisor) num))

(defn rediv [lst1]
     (loop [lst lst1]
         (if (== 1 (first (first lst)))
           lst
           (recur (let [num (first (first lst))
                    divisor (last (first lst))
                    remains (divby num divisor)
                    nextprime (first (filter #(< divisor %) primes))
                    ]
                    (if (== remains num)
                      (cons [remains nextprime] (rest lst))
                    (cons [remains nextprime] lst)))
           )
         )
     )
     )

#(defn problem3 [num]
                 (map last (rest (rediv [[num (first primes)]]))))

#problem 4
(defn ispalin? [num]
                 (let [s (str num)
                       split1 (rest (seq (. s split "")))
                       split2 (reverse split1)
                       ]
                  (every? #(true? %) (map #(= %1 %2) split1 split2))))
(defn multa [num]
              (filter ispalin? (map #(* num %) (range num 99 -1))))
#(defn problem4 []
           (last (sort (mapcat multa (range 999 99 -1)))))

#problem 9
#1000 (a + b) -ab =1000x1000/2- solve for this


#problem 8 input

(def input8 "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450")

(defn intify [lst]
        (map #(. Integer parseInt %) lst))
(defn haszero? [lst]
  (nil? (some zero? lst)))
(defn problem8 [input]
           (let [parted (partition 5 1 (rest (seq (. input split ""))))
                 nownum (map intify parted)
                 zerofiltered (filter haszero? nownum)        
                 ]
             (last (sort (map #(apply * %) zerofiltered)))))

#(problem8 input8)
#40824

#Problem 20
(defn problem20 []
  (apply + (map #(. Integer parseInt %) (rest (seq (. (str (apply * (range 100 0 -1))) split ""))))))
#648
