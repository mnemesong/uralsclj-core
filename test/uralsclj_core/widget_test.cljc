(ns uralsclj-core.widget-test
  (:require [clojure.test :refer :all]
            [uralsclj-core.widget :as w]
            [clojure.spec.alpha :as s]))

(deftest widget-t-test
  (testing "Widget/t may be empty"
    (is (= true (s/valid? :uralsclj-core.widget/t {}))))
  (testing "Widget/t.css may not be collection"
    (is (= false (s/valid? :uralsclj-core.widget/t {:css ["hello"]}))))
  (testing "Widget/t.css may be string"
    (is (= true (s/valid? :uralsclj-core.widget/t {:css "hello"}))))
  (testing "Widget/t.css may not be nil"
    (is (= false (s/valid? :uralsclj-core.widget/t {:css nil}))))
  (testing "Widget/t.css may not be num"
    (is (= false (s/valid? :uralsclj-core.widget/t {:css 12}))))
  (testing "Widget/t.js may not be collection"
    (is (= false (s/valid? :uralsclj-core.widget/t {:js ["hello"]}))))
  (testing "Widget/t.js may be string"
    (is (= true (s/valid? :uralsclj-core.widget/t {:js "hello"}))))
  (testing "Widget/t.js may not be nil"
    (is (= false (s/valid? :uralsclj-core.widget/t {:js nil}))))
  (testing "Widget/t.js may not be num"
    (is (= false (s/valid? :uralsclj-core.widget/t {:js 0.12}))))
  (testing "Widget/t.html may not be collection"
    (is (= false (s/valid? :uralsclj-core.widget/t {:html ["hello"]}))))
  (testing "Widget/t.html may be string"
    (is (= true (s/valid? :uralsclj-core.widget/t {:html "hello"}))))
  (testing "Widget/t.html may not be nil"
    (is (= false (s/valid? :uralsclj-core.widget/t {:html nil}))))
  (testing "Widget/t.html may not be num"
    (is (= false (s/valid? :uralsclj-core.widget/t {:html 0.12})))))

(deftest add-html-test
  (testing "add-html correctly add html"
    (is (= {:html "tet-html" :js "start-js"} (w/add-html {:js "start-js"} "tet-html")))))

(deftest render-test
  (testing "render"
    (is (= {:html "Hello Mike!", :js "Aaa!"}
           (w/render {:html "Hello {{a1}}" :js "{{a2}}!"} 
                     {:a1 "Mike!" :a2 "Aaa"}))))) 