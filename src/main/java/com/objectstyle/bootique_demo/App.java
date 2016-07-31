package com.objectstyle.bootique_demo;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.servlets.MetricsServlet;
import com.google.inject.Binder;
import com.google.inject.BindingAnnotation;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.nhl.bootique.Bootique;
import com.nhl.bootique.jersey.JerseyModule;
import com.nhl.bootique.jetty.JettyModule;
import com.nhl.bootique.jetty.MappedServlet;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;

/**
 * Hello world!
 */
public class App implements Module {

    public static void main(String[] args) {
        Bootique.app(args).autoLoadModules().module(App.class).run();
    }

    @Override
    public void configure(Binder binder) {
        JettyModule.contributeMappedServlets(binder).addBinding().to(Key.get(MappedServlet.class, MetricsMappedServlet.class));
        JerseyModule.contributeResources(binder).addBinding().to(HelloApi.class);
    }

    @MetricsMappedServlet
    @Provides
    MappedServlet mappedMetricsServlet(MetricRegistry registry) {
        MetricsServlet servlet = new MetricsServlet(registry);
        return new MappedServlet(servlet, Collections.singleton("/metrics"), "metrics");
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @BindingAnnotation
    public @interface MetricsMappedServlet {

    }
}
