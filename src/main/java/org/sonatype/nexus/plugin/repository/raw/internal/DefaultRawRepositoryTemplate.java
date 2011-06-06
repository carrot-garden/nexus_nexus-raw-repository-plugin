package org.sonatype.nexus.plugin.repository.raw.internal;

import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.sonatype.nexus.configuration.model.CRepository;
import org.sonatype.nexus.configuration.model.CRepositoryCoreConfiguration;
import org.sonatype.nexus.configuration.model.CRepositoryExternalConfigurationHolderFactory;
import org.sonatype.nexus.configuration.model.DefaultCRepository;
import org.sonatype.nexus.plugin.repository.raw.RawRepository;
import org.sonatype.nexus.proxy.repository.RepositoryWritePolicy;
import org.sonatype.nexus.templates.repository.AbstractRepositoryTemplate;

public class DefaultRawRepositoryTemplate
    extends AbstractRepositoryTemplate
{

    public DefaultRawRepositoryTemplate( final DefaultRawRepositoryTemplateProvider provider, final String id,
                                          final String description )
    {
        super( provider, id, description, new DefaultRawRepositoryContentClass(), RawRepository.class );
    }

    @Override
    protected CRepositoryCoreConfiguration initCoreConfiguration()
    {
        final CRepository repo = new DefaultCRepository();

        repo.setId( "" );

        repo.setProviderRole( RawRepository.class.getName() );
        repo.setProviderHint( DefaultRawRepository.ID );

        final Xpp3Dom ex = new Xpp3Dom( DefaultCRepository.EXTERNAL_CONFIGURATION_NODE_NAME );
        repo.setExternalConfiguration( ex );

        repo.setIndexable( false );

        repo.setWritePolicy( RepositoryWritePolicy.ALLOW_WRITE.name() );
        repo.setNotFoundCacheTTL( 1440 );

        final CRepositoryCoreConfiguration result =
            new CRepositoryCoreConfiguration( getTemplateProvider().getApplicationConfiguration(), repo, new CRepositoryExternalConfigurationHolderFactory<DefaultRawRepositoryConfiguration>()
            {
                public DefaultRawRepositoryConfiguration createExternalConfigurationHolder( final CRepository config )
                {
                    return new DefaultRawRepositoryConfiguration( (Xpp3Dom) config.getExternalConfiguration() );
                }
            } );

        return result;
    }
}
