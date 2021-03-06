/* Copyright 2011-2012 the original author or authors:
 *
 *    Dean Del Ponte (dean.delponte@gmail.com)
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
package org.grails.plugin.platform

import grails.test.mixin.TestFor

@TestFor(UITagLib)
class UITagLibSpec extends SpecificationDataCore {

    def setup() {

        tagLib.metaClass.getActivePluginRequestAttributes = { String key -> return [[name: "Bootstrap"]] }

    }

    def "ifSetActive"() {

        when:
        def results = tagLib.ifSetActive([name: name], "awesome content")

        then:
        results == expectedResults

        where:
        name           | expectedResults
        "Bootstrap"    | "awesome content"
        "doesNotExist" | ""


    }

    def "ifSetNotActive"() {

        when:
        def results = tagLib.ifSetNotActive([name: name], "awesome content")

        then:
        results == expectedResults

        where:
        name           | expectedResults
        "Bootstrap"    | ""
        "doesNotExist" | "awesome content"

    }

}
