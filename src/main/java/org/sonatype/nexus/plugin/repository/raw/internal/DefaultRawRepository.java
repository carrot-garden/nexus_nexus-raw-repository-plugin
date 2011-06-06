package org.sonatype.nexus.plugin.repository.raw.internal;

import javax.inject.Inject;
import javax.inject.Named;

import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.sonatype.nexus.configuration.Configurator;
import org.sonatype.nexus.configuration.model.CRepository;
import org.sonatype.nexus.configuration.model.CRepositoryExternalConfigurationHolderFactory;
import org.sonatype.nexus.plugin.repository.raw.RawRepository;
import org.sonatype.nexus.proxy.registry.ContentClass;
import org.sonatype.nexus.proxy.repository.AbstractRepository;
import org.sonatype.nexus.proxy.repository.DefaultRepositoryKind;
import org.sonatype.nexus.proxy.repository.RepositoryKind;

@Named( DefaultRawRepository.ID )
public class DefaultRawRepository
    extends AbstractRepository
    implements RawRepository
{

    static final String ID = "raw";

    @Inject
    @Named( DefaultRawRepositoryConfigurator.ID )
    private Configurator configurator;

    @Inject
    @Named( DefaultRawRepositoryContentClass.ID )
    private ContentClass contentClass;

    private RepositoryKind repositoryKind;

    @Override
    protected Configurator getConfigurator()
    {
        return configurator;
    }

    @Override
    protected CRepositoryExternalConfigurationHolderFactory<DefaultRawRepositoryConfiguration> getExternalConfigurationHolderFactory()
    {
        return new CRepositoryExternalConfigurationHolderFactory<DefaultRawRepositoryConfiguration>()
        {
            public DefaultRawRepositoryConfiguration createExternalConfigurationHolder( final CRepository config )
            {
                return new DefaultRawRepositoryConfiguration( (Xpp3Dom) config.getExternalConfiguration() );
            }
        };
    }

    public ContentClass getRepositoryContentClass()
    {
        return contentClass;
    }

    public RepositoryKind getRepositoryKind()
    {
        if ( repositoryKind == null )
        {
            repositoryKind = new DefaultRepositoryKind( RawRepository.class, null );
        }

        return repositoryKind;
    }

}
