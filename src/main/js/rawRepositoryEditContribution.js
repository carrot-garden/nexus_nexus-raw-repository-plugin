Ext.override(Sonatype.repoServer.HostedRepositoryEditor, {
      afterProviderSelectHandler : function(combo, rec, index) {
        this.updateIndexableCombo(rec.data.format);

        if (rec.data.provider == 'raw')
        {
          this.find('name', 'writePolicy')[0].setValue('ALLOW_WRITE');
        }

      }
    });