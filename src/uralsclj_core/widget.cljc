(ns uralsclj-core.widget
  (:require [clojure.spec.alpha :as s]
            [clojure.string :as str]
            [uralsclj-core.model :as m]))

(s/def ::html string?)
(s/def ::js string?)
(s/def ::css string?)
(s/def ::t 
  (s/keys :opt-un [::html ::js ::css]))

(defn add-html [w val]
  {:pre [(s/valid? ::html val)]}
  (assoc w :html val))

(defn has-no-empty-prop [w p]
  (and 
    (contains? w p) 
    (> (count (get w p)) 0)))

(defn replace-property [w k m]
  (if 
    (has-no-empty-prop w k) 
    (assoc w k (m/render-to-template (get w k) m))
    w))

(defn render [w m]
  {:pre [(s/valid? ::t w) (coll? m)]}
  (-> w
      (replace-property :html m)
      (replace-property :js m)
      (replace-property :css m)))