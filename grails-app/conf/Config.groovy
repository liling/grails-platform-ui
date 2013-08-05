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
grails.doc.authors = "Marc Palmer (marc@grailsrocks.com)"
grails.doc.license = "ASL 2"
grails.doc.copyright = "2012 Marc Palmer"
grails.doc.footer = "Please contact the authors with any corrections or suggestions"