(defproject becoming-novel "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "https://example.com/FIXME"
  :main becoming-novel.build
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.12.2"]
                 [markdown-clj "1.12.8"]
                 [hbs "1.1.0"]]
  :repl-options {:init-ns becoming-novel.core}
  :aliases {"build" ["run" "-M" "becoming-novel.build"]})
