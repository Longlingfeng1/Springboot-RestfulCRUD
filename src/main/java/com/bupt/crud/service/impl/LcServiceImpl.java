/**
 * @author Liu Cong
 * Created on 2021/4/22
 */

package com.bupt.crud.service.impl;

import com.bupt.crud.service.LcService;
import org.springframework.stereotype.Service;

/**
 * @program: crud
 *
 * @description:
 *
 * @author: LiuCong
 *
 * @create: 2021-04-22 10:35
 **/

@Service
public class LcServiceImpl implements LcService {
    @Override
    public void updateLc() {
        System.out.println("print lc 01");
    }

    @Override
    public void deleteLc() {
        System.out.println("delete lc 01");
    }

}
