String version = '1.0.RC5'
String grailsHomeRoot = '/path/to/your/grails/home'
String dotGrailsCommon = '/path/to/.grails/in/your/home/directory'
String projectDirCommon = '/path/to/target/directory/of/test/apps'

v13 {
    grailsVersion = '1.3.9'
    pluginVersion = version
    dotGrails = dotGrailsCommon
    projectDir = projectDirCommon
    grailsHome = grailsHomeRoot + '/' + grailsVersion
    plugins = ''
    dependencies = ''
}

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

