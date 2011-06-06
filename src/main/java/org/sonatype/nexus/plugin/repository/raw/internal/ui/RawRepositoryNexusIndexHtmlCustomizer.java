package org.sonatype.nexus.plugin.repository.raw.internal.ui;

import java.util.Map;

import javax.inject.Named;
import javax.inject.Singleton;

import org.sonatype.nexus.plugins.rest.AbstractNexusIndexHtmlCustomizer;

@Named
@Singleton
public class RawRepositoryNexusIndexHtmlCustomizer
    extends AbstractNexusIndexHtmlCustomizer
{

    @Override
    public String getPostHeadContribution( final Map<String, Object> ctx )
    {
        final String version =
            getVersionFromJarFile( "/META-INF/maven/org.sonatype.nexus.plugins/nexus-raw-repository-plugin/pom.properties" );

        return "<script src=\"static/js/nexus-raw-repository-plugin-all.js" + ( version == null ? "" : "?" + version )
            + "\" type=\"text/javascript\" charset=\"utf-8\"></script>";
    }

}
