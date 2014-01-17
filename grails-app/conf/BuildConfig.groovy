grails.project.work.dir = 'target'

grails.project.dependency.resolution = {

    inherits 'global'
    log 'warn'

    repositories {
        grailsCentral()
        mavenLocal()
        mavenCentral()
    }

    dependencies {
        build('org.grails:grails-gdoc-engine:1.0.1') {
            export = false
        }

        test "org.spockframework:spock-grails-support:0.7-groovy-2.0"
    }

    plugins {
        build ':release:2.2.1', ':rest-client-builder:1.0.3', {
            export = false
        }

        compile(":hibernate:$grailsVersion") {
            export = false
        }

        compile ':platform-core:1.0.RC5'
        runtime ":resources:1.2.RC2"

        test(":spock:0.7") {
            exclude "spock-grails-support"
        }
    }
}
