(ns becoming-novel.core
  (:require
   [clojure.edn :as edn]
   [markdown.core :as markdown]))

(def toc-string (slurp "resources/toc.edn"))
(def toc (edn/read-string toc-string))

(def entries
  (for [{:keys [content] :as entry} toc
        :let [html-string (markdown/md-to-html-string (slurp content))]]
    (assoc entry :html html-string)))
