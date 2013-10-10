log4j = {
    error 'org.codehaus.groovy.grails',
          'org.springframework',
          'org.hibernate',
          'net.sf.ehcache.hibernate'
}

grails.validateable.packages = ['org.grails.plugin.platform.test']

grails.doc.title = "Grails Platform UI"
grails.doc.subtitle = "APIs and Tags for Theming and Plugin UI integration"
grails.doc.images = new File("src/docs/img")
grails.doc.css = new File('src/docs/css')
grails.doc.authors = "Dean Del Ponte (dean.delponte@gmail.com), Marc Palmer (marc@grailsrocks.com)"
grails.doc.license = "ASL 2"
grails.doc.copyright = "2013 Marc Palmer & Dean Del Ponte"
grails.doc.footer = "Please contact the authors with any corrections or suggestions"grails.views.default.codec="none" // none, html, base64
grails.views.gsp.encoding="UTF-8"
