package com.wsm.service;

import com.wsm.NotFoundException;
import com.wsm.repository.TypeRepository;
import com.wsm.entity.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 对分类页面的业务层操作
 */

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    //保存
    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    //通过id获取type
    @Transactional
    @Override
    public Type getType(Long id) {
        return typeRepository.findById(id).orElse(null);
    }

    //通过名字获取type
    @Override
    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }

    //分页操作
    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    //查询全部分类
    @Override
    public List<Type> listType() {
        return typeRepository.findAll();
    }

    //分页排序
    @Override
    public List<Type> listTypeTop(Integer size) {
        return typeRepository.findTop(PageRequest.of(0, size, Sort.by(Sort.Direction.DESC, "blogs.size")));

    }

    //修改type
    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        Type t = typeRepository.findById(id).orElse(null);
        if (t == null) {
            throw new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(type,t);
        return typeRepository.save(t);
    }


    //删除type
    @Transactional
    @Override
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }
}
