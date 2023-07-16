(ns uralsclj-core.widget-test
  (:require [clojure.test :refer :all]
            [uralsclj-core.widget :refer :all]
            [clojure.spec.alpha :as s]))

(deftest widget-dsl-test
  (testing "Widget/dsl may be empty"
    (is (= true (s/valid? :uralsclj-core.widget/dsl {}))))
  (testing "Widget/dsl.css may not be collection"
    (is (= false (s/valid? :uralsclj-core.widget/dsl {:css ["hello"]}))))
  (testing "Widget/dsl.css may be string"
    (is (= true (s/valid? :uralsclj-core.widget/dsl {:css "hello"}))))
  (testing "Widget/dsl.css may not be nil"
    (is (= false (s/valid? :uralsclj-core.widget/dsl {:css nil}))))
  (testing "Widget/dsl.css may not be num"
    (is (= false (s/valid? :uralsclj-core.widget/dsl {:css 12}))))
  (testing "Widget/dsl.js may not be collection"
    (is (= false (s/valid? :uralsclj-core.widget/dsl {:js ["hello"]}))))
  (testing "Widget/dsl.js may be string"
    (is (= true (s/valid? :uralsclj-core.widget/dsl {:js "hello"}))))
  (testing "Widget/dsl.js may not be nil"
    (is (= false (s/valid? :uralsclj-core.widget/dsl {:js nil}))))
  (testing "Widget/dsl.js may not be num"
    (is (= false (s/valid? :uralsclj-core.widget/dsl {:js 0.12}))))
  (testing "Widget/dsl.html may not be collection"
    (is (= false (s/valid? :uralsclj-core.widget/dsl {:html ["hello"]}))))
  (testing "Widget/dsl.html may be string"
    (is (= true (s/valid? :uralsclj-core.widget/dsl {:html "hello"}))))
  (testing "Widget/dsl.html may not be nil"
    (is (= false (s/valid? :uralsclj-core.widget/dsl {:html nil}))))
  (testing "Widget/dsl.html may not be num"
    (is (= false (s/valid? :uralsclj-core.widget/dsl {:html 0.12})))))

(deftest add-html-test
  (testing "add-html correctly add html"
    (is (= {:html "tet-html" :js "start-js"} (add-html {:js "start-js"} "tet-html")))))

(deftest has-no-empty-prop-test
  (testing "has-no-empty-prop on not empty prop hashmap exist prop"
    (is (= true (has-no-empty-prop {:html "alola"} :html))))
  (testing "has-no-empty-prop on not empty prop hashmap not exist prop"
    (is (= false (has-no-empty-prop {:html "alola"} :js))))
  (testing "has-no-empty-prop on nil"
    (is (= false (has-no-empty-prop {:html nil} :html))))
  (testing "has-no-empty-prop on empty string"
    (is (= false (has-no-empty-prop {:html ""} :html)))))

(deftest insert-attr-to-template-test
  (testing "insert-attr-to-template no match"
    (is (= "{{ajja}}" (insert-attr-to-template "{{ajja}}" "html" "gogo"))))
  (testing "insert-attr-to-template match"
    (is (= "hello gogo!" (insert-attr-to-template "hello {{html}}!" "html" "gogo")))))

