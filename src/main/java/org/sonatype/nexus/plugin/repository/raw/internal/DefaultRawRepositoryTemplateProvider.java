package org.sonatype.nexus.plugin.repository.raw.internal;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.codehaus.plexus.personality.plexus.lifecycle.phase.Initializable;
import org.codehaus.plexus.personality.plexus.lifecycle.phase.InitializationException;
import org.sonatype.nexus.plugin.repository.raw.RawRepository;
import org.sonatype.nexus.proxy.registry.RepositoryTypeDescriptor;
import org.sonatype.nexus.proxy.registry.RepositoryTypeRegistry;
import org.sonatype.nexus.templates.TemplateSet;
import org.sonatype.nexus.templates.repository.AbstractRepositoryTemplateProvider;

@Named
@Singleton
public class DefaultRawRepositoryTemplateProvider
    extends AbstractRepositoryTemplateProvider
    implements Initializable
{

    private static final String ID = "raw";

    @Inject
    private RepositoryTypeRegistry repositoryTypeRegistry;

    public TemplateSet getTemplates()
    {
        final TemplateSet templates = new TemplateSet( null );

        try
        {
            templates.add( new DefaultRawRepositoryTemplate( this, ID, "Raw Repository" ) );
        }
        catch ( final Exception e )
        {
            // will not happen
        }

        return templates;
    }

    public void initialize()
        throws InitializationException
    {
        repositoryTypeRegistry.registerRepositoryTypeDescriptors( new RepositoryTypeDescriptor( RawRepository.class,
            DefaultRawRepository.ID, "repositories" ) );
    }
}
