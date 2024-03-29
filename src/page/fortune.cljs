(ns page.fortune
  (:require
   [reagent.core :as r]
   [goldly.service.core :as service]
   [lib.ui :refer [wrap-page-site]]))

(def cookie-state (r/atom nil))

(defn fortune []
  [:div
   [:h1.text-blue-500.text-xl "Fortune Cookies"]
   [:p "a demonstration to call server-side clj-functions (clj based)."]
   [:p "This would work with read database queries also :-)"]

   [:button {:class "border m-2 p-3 border-pink-500"
             :on-click (fn [& _]
                         (service/run-a cookie-state [:cookie] 'fortune-cookie/get-cookie 3))} "get a specific cookie"]
   [:button {:class "border m-2 p-3 border-blue-300 bg-red-100"
             :on-click (fn [& _]
                         (service/run-a cookie-state [:cookie] 'fortune-cookie/get-cookie))} "get a random cookie"]
   [:p.bg-yellow-500.italic.text-xl.text-blue-700
    (or (:cookie @cookie-state) "no cookie received!")]])

(defn fortune-page [_route-data]
  [:div
   [fortune]])

(def fortune-page-wrapped (wrap-page-site fortune-page))

