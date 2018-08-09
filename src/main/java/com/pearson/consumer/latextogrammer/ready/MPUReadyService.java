package com.pearson.consumer.latextogrammer.ready;

import org.springframework.stereotype.Component;

import com.pearson.glp.crosscutting.logger.factory.LoggerFactory;
import com.pearson.glp.crosscutting.logger.service.Logger;
import com.pearson.platform.common.api.ready.api.AbstractReadyService;
import com.pearson.platform.common.utils.exception.PlatformException;

/**
 * The Class MPUReadyService.
 *
 * @author vinit.srivastava
 */
@Component
public class MPUReadyService extends AbstractReadyService {

    /** The logger. */
    private Logger LOGGER = LoggerFactory
            .getLogger(MPUReadyService.class);

  /**
   * Instantiates a new GradebookReadyService ready service. constructor for
   * Instantiatation used in apps
   */
  /**
   * Public Constructor.
   */
  public MPUReadyService() {
    super();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.pearson.platform.common.api.ready.api.AbstractReadyService#ready()
   */
  @Override
  public boolean ready() throws PlatformException {
      LOGGER
      .info("ready() in LADReadyService");
    return true;
  }

}