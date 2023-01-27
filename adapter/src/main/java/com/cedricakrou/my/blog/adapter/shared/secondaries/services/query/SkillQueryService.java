package com.cedricakrou.my.blog.adapter.shared.secondaries.services.query;

import com.cedricakrou.my.blog.adapter.shared.primaries.rest.vm.SkillVm;
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
