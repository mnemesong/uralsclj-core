(ns uralsclj-core.model
  (:require [clojure.spec.alpha :as s]
            [clojure.string :as str]))

(s/def ::t map?)

(defn- insert-attr-to-template [s srch rplc]
  (str/replace s (re-pattern (str "\\{\\{" srch "\\}\\}")) rplc))

(defn- model-print-reducer [acc m]
  {:pre [
    (string? acc)  
    (and (contains? m :key) (contains? m :val))
  ]}
  (insert-attr-to-template acc (:key m) (:val m)))

(defn- map-to-key-vals-array [m k] {
    :key (if (keyword? k) (name k) k) 
    :val (get m k)
    })

(defn render-to-template [str m]
  (->> (keys m)
    (map #(map-to-key-vals-array m %))
    (reduce model-print-reducer str)))
