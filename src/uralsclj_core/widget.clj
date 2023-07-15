(ns uralsclj-core.widget
  (:require [clojure.spec.alpha :as s]))

(defn source? [x] (or (string? x) (coll? x)))

(s/def ::html source?)
(s/def ::js source?)
(s/def ::css source?)
(s/def ::dsl 
  (s/keys :opt-un [::html ::js ::css]))
