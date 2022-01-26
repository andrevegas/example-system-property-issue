package com.example.config;

import io.micronaut.context.annotation.Property;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/*
-Dmy-configuration.config-a.foo.BAR='baz'
-Dmy-configuration.config-b.foo.BAR='baz'
-Dmy-configuration.config-c.foo[BAR]='baz'
-Dmy-configuration.config-d.foo.BAR='baz'
 */
@Property(name = "my-configuration.config-a.foo.BAR1", value = "baz1")
@Property(name = "my-configuration.config-b.foo.BAR", value = "baz")
@Property(name = "my-configuration.config-c.foo[BAR]", value = "baz")
@Property(name = "my-configuration.config-d.foo.BAR", value = "baz")

@MicronautTest
public class MyConfigurationTest {

    @Named("config-a")
    @Inject
    MyConfiguration configA;
    @Named("config-b")
    @Inject
    MyConfiguration configB;
    @Named("config-c")
    @Inject
    MyConfiguration configC;
    @Named("config-d")
    @Inject
    MyConfiguration configD;


    @Test
    void check_config_property_value_a() {
        assertNotNull(configA);
        assertNotNull(configA.getFoo());
        assertEquals(2, configA.getFoo().size());
        assertEquals(configA.getFoo().keySet().toArray()[0], "bar");
        assertEquals(configA.getFoo().keySet().toArray()[1], "bar1");
    }

    @Test
    void check_config_property_value_b() {
        assertNotNull(configB);
        assertNotNull(configB.getFoo());
        assertEquals(1, configB.getFoo().size());
        assertEquals(configB.getFoo().keySet().toArray()[0], "bar");
    }

    @Test
    void check_config_property_value_c() {
        assertNotNull(configC);
        assertNotNull(configC.getFoo());
        assertEquals(1, configC.getFoo().size());
        assertEquals(configC.getFoo().keySet().toArray()[0], "bar");
    }

    @Test
    void check_config_property_value_d() {
        assertNotNull(configD);
        assertNotNull(configD.getFoo());
        assertEquals(1, configD.getFoo().size());
        assertEquals(configD.getFoo().keySet().toArray()[0], "bar");
    }

}
