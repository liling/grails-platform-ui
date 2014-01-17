/* Copyright 2011-2012 the original author or authors:
 *
 *    Dean Del Ponte (dean.delponte@gmail.com)
 *    Marc Palmer (marc@grailsrocks.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.grails.plugin.platform.themes.Themes
import org.grails.plugin.platform.ui.UISets
import org.grails.plugin.platform.views.Grails13ViewFinder
import org.springframework.beans.factory.config.PropertiesFactoryBean
import org.springframework.core.io.FileSystemResource

class PlatformUiGrailsPlugin {
    def version = "1.0.RC7"
    def grailsVersion = "2.0 > *"

    def pluginExcludes = [
            "grails-app/conf/TestResources.groovy",
            "grails-app/i18n/test.properties",
            "grails-app/src/groovy/org/grails/plugin/platform/test/**",
            "src/docs/**",
            "testapps.config.groovy"
    ]

    def title = "Plugin Platform UI"
    def description = 'Platform UI - abstracted UI elements and theming for plugin/application interoperability'

    def watchedResources = [
            "file:./grails-app/views/_ui/**/*.gsp",
            "file:./grails-app/views/_themes/**/*.gsp",
            "file:./grails-app/views/layouts/themes/**/*.gsp"
            // We don't monitor plugins, it is only needed for inline plugins and slows it all down
    ]

    def loadAfter = ['platformCore', 'logging']

    def documentation = "http://platform-ui.org/doc/latest/"

    def license = "APACHE"

    def organization = [name: "Grailsrocks", url: "http://grailsrocks.com/"]

    def developers = [
            [name: "Marc Palmer", email: "marc@grailsrocks.com"],
            [name: "Dean Del Ponte", email: "dean.delponte@gmail.com"]
    ]

    def issueManagement = [system: "JIRA", url: "http://jira.grails.org/browse/GPPLATUI"]

    def scm = [url: "https://github.com/MerryCoders/grails-platform-ui"]

    /**
     * This happens all the time, but dWWD may not have run if we're in a WAR
     */
    def doWithSpring = {

        grailsViewFinder(Grails13ViewFinder) {
            groovyPagesUriService = ref('groovyPagesUriService')
            grailsApplication = ref('grailsApplication')
            pluginManager = ref('pluginManager')

            if (application.warDeployed) {
                precompiledGspMap = { PropertiesFactoryBean pfb ->
                    ignoreResourceNotFound = true
                    location = "classpath:gsp/views.properties"
                }
            }
        }

        // Themes API
        grailsThemes(Themes) {
            grailsApplication = ref('grailsApplication')
            grailsViewFinder = ref('grailsViewFinder')
            pluginManager = ref('pluginManager')
            grailsPluginConfiguration = ref('grailsPluginConfiguration')
            grailsUiExtensions = ref('grailsUiExtensions')
        }

        // UI API
        grailsUISets(UISets) {
            grailsViewFinder = ref('grailsViewFinder')
            pluginManager = ref('pluginManager')
            grailsPluginConfiguration = ref('grailsPluginConfiguration')
            grailsThemes = ref('grailsThemes')
            grailsUiExtensions = ref('grailsUiExtensions')
        }
    }

    def doWithDynamicMethods = { ctx ->
        ctx.grailsInjection.initInjections()
    }

    def doWithConfigOptions = {
        'theme.default'(type: String, defaultValue: null)
        'theme.layout.default'(type: String, defaultValue: "main")

        'ui.set'(type: String, defaultValue: "_default")
        // @todo '*' syntax not supported yet
        //'themes.layout.mapping.*'(type:String)
        //'themes.*.layout.mapping.*'(type:String)
        //'themes.*.ui.set'(type:String)
        //'themes.*.ui.*.cssClass'(type:String)
    }

    def doWithConfig = {
        platformUi {
            themes.'_default'.ui.set = '_default'
        }
    }

    def doWithInjection = { ctx -> }

    def onChange = { event ->
        if (event.source == FileSystemResource) {
            // @todo this is too promiscuous
            event.application.mainContext.grailsThemes.reload()
        }
    }
}
