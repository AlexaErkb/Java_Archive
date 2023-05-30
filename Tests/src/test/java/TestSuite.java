import org.example.Test1;
import org.example2.Test2;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.ExcludePackages;


@Suite
@SelectPackages({
        "org"
})
@ExcludePackages({
        "org.example2"
})
public class TestSuite {
}
