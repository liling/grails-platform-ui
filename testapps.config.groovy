String version = '1.0.RC7'
String grailsHomeRoot = '/Users/deandelponte/.gvm/grails'
String dotGrailsCommon = '/Users/deandelponte/.grails'
String projectDirCommon = '/Users/deandelponte/code/testapps/platform-ui'

v20 {
    grailsVersion = '2.0.4'
    pluginVersion = version
    dotGrails = dotGrailsCommon
    projectDir = projectDirCommon
    grailsHome = grailsHomeRoot + '/' + grailsVersion
    plugins = '        test ":spock:0.7"'
    dependencies = ''
}

v21 {
    grailsVersion = '2.1.5'
    pluginVersion = version
    dotGrails = dotGrailsCommon
    projectDir = projectDirCommon
    grailsHome = grailsHomeRoot + '/' + grailsVersion
    plugins = '        test ":spock:0.7"'
    dependencies = ''
}

v22 {
    grailsVersion = '2.2.4'
    pluginVersion = version
    dotGrails = dotGrailsCommon
    projectDir = projectDirCommon
    grailsHome = grailsHomeRoot + '/' + grailsVersion
    plugins = """        test(":spock:0.7") {
                exclude "spock-grails-support"
            }"""
    dependencies = 'test "org.spockframework:spock-grails-support:0.7-groovy-2.0"'
}

v23 {
    grailsVersion = '2.3.5'
    pluginVersion = version
    dotGrails = dotGrailsCommon
    projectDir = projectDirCommon
    grailsHome = grailsHomeRoot + '/' + grailsVersion
}

