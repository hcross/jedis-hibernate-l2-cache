import org.cleancodejunkies.test.IntegrationTest
import org.cleancodejunkies.test.UnitTest

def testAnnotations = [
        unit: UnitTest,
        integration: IntegrationTest
]
def testTypes = System.getProperty('testTypes')?.split(',\\s*')?.collect {testAnnotations[it.toLowerCase()]}

runner {
    testTypes?.each { testType ->
        include.annotations << testType
    }
    testTypes ?: include.annotations << UnitTest
}