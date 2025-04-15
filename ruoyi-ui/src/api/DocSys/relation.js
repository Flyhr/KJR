import request from '@/utils/request'

// 查询医生患者关系列表
export function listRelation(query) {
  return request({
    url: '/DocSys/relation/list',
    method: 'get',
    params: query
  })
}

// 查询医生患者关系详细
export function getRelation(id) {
  return request({
    url: '/DocSys/relation/' + id,
    method: 'get'
  })
}

// 新增医生患者关系
export function addRelation(data) {
  return request({
    url: '/DocSys/relation',
    method: 'post',
    data: data
  })
}

// 修改医生患者关系
export function updateRelation(data) {
  return request({
    url: '/DocSys/relation',
    method: 'put',
    data: data
  })
}

// 删除医生患者关系
export function delRelation(id) {
  return request({
    url: '/DocSys/relation/' + id,
    method: 'delete'
  })
}
