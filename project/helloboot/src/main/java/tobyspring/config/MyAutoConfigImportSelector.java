package tobyspring.config;

import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

public class MyAutoConfigImportSelector implements DeferredImportSelector {
    private final ClassLoader classLoader;

    public MyAutoConfigImportSelector(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        /*return new String[]{
                "tobyspring.config.autoconfig.DispatcherServletConfig",
                "tobyspring.config.autoconfig.TomcatWebServletConfig"
        };*/
        List<String> autoConfigs = new ArrayList<>();

        for(String candidate : ImportCandidates.load(MyAutoConfiguration.class, classLoader)) {
            autoConfigs.add(candidate);
            //
        }

        return autoConfigs.toArray(new String[0]);
    }
}
