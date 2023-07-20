(ns uralsclj-core.widget
  (:require [clojure.spec.alpha :as s]
            [clojure.string :as str]
            [uralsclj-core.model :as m]
            [uralsclj-core.struct :as struct]))

(s/def ::html string?)
(s/def ::js string?)
(s/def ::css string?)
(s/def ::t 
  (s/keys :opt-un [::html ::js ::css]))

(defn add-html [w val]
  {:pre [(s/valid? ::html val)]}
  (assoc w :html val))

(defn render [w m]
  {:pre [(s/valid? ::t w) (coll? m)]}
  (-> w
      (struct/replace-property :html m)
      (struct/replace-property :js m)
      (struct/replace-property :css m)))