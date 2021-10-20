package org.danyuan.application.common.base;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 文件名 ： BaseServiceImpl.java
 * 包 名 ： org.danyuan.application.common.base
 * 描 述 ： 通用服务层实现
 * 作 者 ： wang
 * 时 间 ： 2018年12月8日 上午9:41:12
 * 版 本 ： V1.0
 */
@NoRepositoryBean
public class BaseServiceImpl<T> implements BaseService<T> {
	
	@Autowired
	BaseDao<T> baseDao;
	
	/**
	 * 方法名 ： findOne
	 * 功 能 ： 安条件查询一条
	 * 参 数 ： @param entity
	 * 参 数 ： @return
	 * 参 考 ： @see org.danyuan.application.common.base.BaseService#findOne(java.lang.Object)
	 * 作 者 ： wang
	 */
	
	@Override
	public T findOne(T entity) {
		if (entity == null) {
			return null;
		}
		Example<T> example = Example.of(entity);
		Optional<T> optional = baseDao.findOne(example);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	/**
	 * 方法名 ： findById
	 * 功 能 ： 按id查询一条
	 * 参 数 ： @param id
	 * 参 数 ： @return
	 * 参 考 ： @see org.danyuan.application.common.base.BaseService#findById(java.lang.String)
	 * 作 者 ： wang
	 */
	
	@Override
	public T findById(String id) {
		if (id == null || "".equals(id)) {
			return null;
		}
		Optional<T> optional = baseDao.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	/**
	 * 方法名 ： findAll
	 * 功 能 ： 按条件查询全部数据
	 * 参 数 ： @param entity
	 * 参 数 ： @return
	 * 参 考 ： @see org.danyuan.application.common.base.BaseService#findAll(java.lang.Object)
	 * 作 者 ： wang
	 */
	
	@Override
	public List<T> findAll(T entity) {
		if (entity == null) {
			return baseDao.findAll();
		} else {
			Example<T> example = Example.of(entity);
			List<T> list = baseDao.findAll(example);
			return list;
		}
		
	}
	
	/**
	 * 方法名 ： save
	 * 功 能 ： 保存数据
	 * 参 数 ： @param entity
	 * 参 考 ： @see org.danyuan.application.common.base.BaseService#save(java.lang.Object)
	 * 作 者 ： wang
	 */
	
	@Override
	public T save(T entity) {
		if (entity == null) {
			return null;
		}
		Field[] fields = entity.getClass().getSuperclass().getDeclaredFields();
		boolean fluxFlag = true;
		boolean fluxDeleteFlag = true;
		for (Field field : fields) {
			field.setAccessible(true);
			// # 要求实体类必须要有uuid 或者需要继承 @MappedSuperclass<BaseEntity>
			if ("uuid".equals(field.getName())) {
				try {
					if (field.get(entity) == null || "".equals(field.get(entity).toString())) {
						field.set(entity, UUID.randomUUID().toString());
					}
					fluxFlag = false;
					// 成功赋值id 中断循环
					break;
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			
			if ("deleteFlag".equals(field.getName())) {
				try {
					if (field.get(entity) == null) {
						field.set(entity, 0);
					}
					fluxDeleteFlag = false;
					// 成功赋值id 中断循环
					break;
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		// 如果超类中没有 这访问entity
		if (fluxFlag) {
			fields = entity.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				// # 要求实体类必须要有uuid 或者需要继承 @MappedSuperclass<BaseEntity>
				if ("uuid".equals(field.getName())) {
					try {
						if (field.get(entity) == null || "".equals(field.get(entity).toString())) {
							field.set(entity, UUID.randomUUID().toString());
						}
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
				
			}
		}
		
		if (fluxDeleteFlag) {
			fields = entity.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				// # 要求实体类必须要有deleteFlag 或者需要继承 @MappedSuperclass<BaseEntity>
				if ("deleteFlag".equals(field.getName())) {
					try {
						if (field.get(entity) == null) {
							field.set(entity, 0);
						}
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
				
			}
		}
		return baseDao.save(entity);
	}
	
	/**
	 * 方法名 ： saveAll
	 * 功 能 ： 更改多个数据
	 * 参 数 ： @param entities
	 * 参 考 ： @see org.danyuan.application.common.base.BaseService#saveAll(java.util.List)
	 * 作 者 ： wang
	 */
	
	@Override
	public void saveAll(List<T> entities) {
		baseDao.saveAll(entities);
	}
	
	/**
	 * 方法名 ： delete
	 * 功 能 ： 删除数据
	 * 参 数 ： @param entity
	 * 参 考 ： @see org.danyuan.application.common.base.BaseService#delete(java.lang.Object)
	 * 作 者 ： wang
	 */
	
	@Override
	public void delete(T entity) {
		baseDao.delete(entity);
	}
	
	/**
	 * 方法名 ： deleteAll
	 * 功 能 ： 删除多个数据
	 * 参 数 ： @param entities
	 * 参 考 ： @see org.danyuan.application.common.base.BaseService#deleteAll(java.util.List)
	 * 作 者 ： wang
	 */
	
	@Override
	public void deleteAll(List<T> entities) {
		baseDao.deleteAll(entities);
	}
	
	/**
	 * 方法名 ： trunc
	 * 功 能 ： 清空表数据
	 * 参 数 ：
	 * 参 考 ： @see org.danyuan.application.common.base.BaseService#trunc()
	 * 作 者 ： wang
	 */
	
	@Override
	public void trunc() {
		baseDao.deleteAllInBatch();
	}
	
	/**
	 * 方法名 ： findAll
	 * 功 能 ： 按条件查询多个信息
	 * 参 数 ： @param vo
	 * 参 数 ： @return
	 * 参 考 ： @see org.danyuan.application.common.base.BaseService#findAll(org.danyuan.application.common.base.Pagination)
	 * 作 者 ： wang
	 */
	
	@Override
	public List<T> findAll(Pagination<T> vo) {
		Sort sort = vo.sort();
		if (vo.getInfo() == null) {
			if (sort != null) {
				return baseDao.findAll(sort);
			} else {
				return baseDao.findAll();
			}
		} else {
			Example<T> example = Example.of(vo.getInfo());
			if (sort != null) {
				return baseDao.findAll(example, sort);
			} else {
				return baseDao.findAll(example);
			}
		}
		
	}
	
	/**
	 * 方法名 ： page
	 * 功 能 ： 分页查询
	 * 参 数 ： @param vo
	 * 参 数 ： @return
	 * 参 考 ： @see org.danyuan.application.common.base.BaseService#page(org.danyuan.application.common.base.Pagination)
	 * 作 者 ： wang
	 */
	
	@Override
	public Page<T> page(Pagination<T> vo) {
		Sort sort = vo.sort();
		if (vo.getSearchList() != null && vo.getSearchList().size() > 0) {
			Specification<T> specification = new Specification<T>() {
				/**
				 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
				 */
				private static final long serialVersionUID = 1L;
				
				@Override
				public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
					List<Predicate> list = new ArrayList<>();
					for (SearchParameters parameter : vo.getSearchList()) {
						
						list.add(paramterPredicate(root, query, criteriaBuilder, parameter));
					}
					
					return criteriaBuilder.and(list.toArray(new Predicate[list.size()]));
				}
				
			};
			if (sort != null) {
				PageRequest request = PageRequest.of(vo.getPageNumber() - 1, vo.getPageSize(), sort);
				return baseDao.findAll(specification, request);
			} else {
				PageRequest request = PageRequest.of(vo.getPageNumber() - 1, vo.getPageSize());
				return baseDao.findAll(specification, request);
			}
		} else if (vo.getInfo() == null) {
			if (sort != null) {
				PageRequest request = PageRequest.of(vo.getPageNumber() - 1, vo.getPageSize(), sort);
				return baseDao.findAll(request);
			} else {
				PageRequest request = PageRequest.of(vo.getPageNumber() - 1, vo.getPageSize());
				return baseDao.findAll(request);
			}
		} else {
			Example<T> example = Example.of(vo.getInfo());
			
			if (sort != null) {
				PageRequest request = PageRequest.of(vo.getPageNumber() - 1, vo.getPageSize(), sort);
				return baseDao.findAll(example, request);
			} else {
				PageRequest request = PageRequest.of(vo.getPageNumber() - 1, vo.getPageSize());
				return baseDao.findAll(example, request);
			}
		}
		
	}
	
	/**
	 * 方法名： paramterPredicate
	 * 功 能： TODO(这里用一句话描述这个方法的作用)
	 * 参 数： @param root
	 * 参 数： @param query
	 * 参 数： @param criteriaBuilder
	 * 参 数： @param parameter
	 * 参 数： @return
	 * 返 回： Predicate
	 * 作 者 ： Administrator
	 * @throws
	 */
	protected Predicate paramterPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder, SearchParameters parameter) {
		Predicate predicate = null;
		
		switch (parameter.getOperator()) {
			case "and":
				predicate = criteriaBuilder.and(paramterOperatePredicate(root, query, criteriaBuilder, parameter));
				break;
			case "or":
				predicate = criteriaBuilder.or(paramterOperatePredicate(root, query, criteriaBuilder, parameter));
				break;
			default:
				predicate = criteriaBuilder.and(paramterOperatePredicate(root, query, criteriaBuilder, parameter));
				break;
		}
		if (parameter.getSubParameters() != null && parameter.getSubParameters().size() > 0) {
			List<Predicate> list = new ArrayList<>();
			list.add(predicate);
			for (SearchParameters parameter2 : parameter.getSubParameters()) {
				list.add(paramterPredicate(root, query, criteriaBuilder, parameter2));
			}
			predicate = criteriaBuilder.and(list.toArray(new Predicate[list.size()]));
		}
		
		return predicate;
	}
	
	/**
	 * 方法名： paramterOperatePredicate
	 * 功 能： TODO(这里用一句话描述这个方法的作用)
	 * 参 数： @param root
	 * 参 数： @param query
	 * 参 数： @param criteriaBuilder
	 * 参 数： @param parameter
	 * 参 数： @return
	 * 返 回： Predicate
	 * 作 者 ： Administrator
	 * @throws
	 */
	protected Predicate paramterOperatePredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder, SearchParameters parameter) {
		Predicate predicate = null;
		if (parameter.getColumn() == null || parameter.getData() == null || parameter.getSymbol() == null) {
			return predicate;
		}
		switch (parameter.getSymbol()) {
			case "eq":
				// eq("=", "相等"),
				predicate = criteriaBuilder.equal(root.get(parameter.getColumn()), parameter.getData());
				break;
			case "less":
				// less("<", "小于"),
				predicate = criteriaBuilder.lessThan(root.get(parameter.getColumn()), parameter.getData());
				break;
			case "lessAndEq":
				// lessAndEq("<=", "小于等于"),
				predicate = criteriaBuilder.lessThanOrEqualTo(root.get(parameter.getColumn()), parameter.getData());
				break;
			case "great":
				// great(">", "大于"),
				predicate = criteriaBuilder.greaterThan(root.get(parameter.getColumn()), parameter.getData());
				break;
			case "greatAndEq":
				// greatAndEq(">=", "大于等于")
				predicate = criteriaBuilder.greaterThanOrEqualTo(root.get(parameter.getColumn()), parameter.getData());
				break;
			case "like":
				// like
				predicate = criteriaBuilder.like(root.get(parameter.getColumn()), "%" + parameter.getData().replace(" ", "%") + "%");
				break;
			case "is null":
				// is null
				predicate = criteriaBuilder.isNull(root.get(parameter.getColumn()));
				break;
			case "is not null":
				// is not null
				predicate = criteriaBuilder.isNotNull(root.get(parameter.getColumn()));
				break;
			case "is empty":
				// is empty
				predicate = criteriaBuilder.isEmpty(root.get(parameter.getColumn()));
				break;
			case "is not empty":
				// is not empty
				predicate = criteriaBuilder.isNotEmpty(root.get(parameter.getColumn()));
				break;
			default:
				predicate = criteriaBuilder.equal(root.get(parameter.getColumn()), parameter.getData());
				break;
		}
		return predicate;
	}
	
	/**
	 * 统计数量
	 * 
	 * @方法名 count
	 * @参数 @param info
	 * @参数 @return
	 * @参考 @see org.danyuan.application.common.base.BaseService#count(java.lang.Object)
	 * @author Administrator
	 */
	
	@Override
	public Long count(T info) {
		if (info == null) {
			return baseDao.count();
		} else {
			Example<T> example = Example.of(info);
			return baseDao.count(example);
		}
	}
	
}
