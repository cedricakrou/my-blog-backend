package com.cedricakrou.my.blog.shared.application.facade;

import com.cedricakrou.my.blog.shared.application.service.CountryService;
import com.cedricakrou.my.blog.shared.application.service.PermissionService;
import com.cedricakrou.my.blog.shared.application.service.RoleService;

/**
 * <p>
 * Aggregate Shared Facade which permits to implements
 * all Services of aggregate shared.
 * </p>
 *
 * @author KAKOU Akrou Cedric 2023-01-11
 */
public interface SharedFacade extends CountryService,
        RoleService,
        PermissionService {
}
