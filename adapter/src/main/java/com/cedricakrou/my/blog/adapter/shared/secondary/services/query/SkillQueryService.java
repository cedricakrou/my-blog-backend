package com.cedricakrou.my.blog.adapter.shared.secondary.services.query;

import com.cedricakrou.my.blog.adapter.shared.primary.rest.vm.SkillVm;
import java.util.List;

/**
 * <p>Service for querying skills in the database.</p>
 *
 * @author KAKOU Akrou Cedric 2023-01-19
 */
public interface SkillQueryService {

  /**
   * <p>Get all skills.</p>
   *
   * @return list of skills.
   */
  List<SkillVm> findAll();
}
