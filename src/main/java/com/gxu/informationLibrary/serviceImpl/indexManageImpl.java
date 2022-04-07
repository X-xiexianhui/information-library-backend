package com.gxu.informationLibrary.serviceImpl;

import com.gxu.informationLibrary.entity.index;
import com.gxu.informationLibrary.server.indexManage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class indexManageImpl implements indexManage {

    @Override
    public List<index> alterIndex() {
        addIndex();
        deleteIndex();
        updateIndex();
        return getIndex();
    }

    private void addIndex() {

    }
    private void deleteIndex(){

    }
    private void updateIndex(){

    }
    private List<index> getIndex(){
        return null;
    }
}
