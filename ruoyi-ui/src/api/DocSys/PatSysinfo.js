import request from '@/utils/request'

// 查询患者信息列表
export function listPatSysinfo(query) {
  return request({
    url: '/DocSys/PatSysinfo/list',
    method: 'get',
    params: query
  })
}

// 查询患者信息详细
export function getPatSysinfo(patId) {
  return request({
    url: '/DocSys/PatSysinfo/' + patId,
    method: 'get'
  })
}

// 新增患者信息
export function addPatSysinfo(data) {
  return request({
    url: '/DocSys/PatSysinfo',
    method: 'post',
    data: data
  })
}

// 修改患者信息
export function updatePatSysinfo(data) {
  return request({
    url: '/DocSys/PatSysinfo',
    method: 'put',
    data: data
  })
}

// 删除患者信息
export function delPatSysinfo(patId) {
  return request({
    url: '/DocSys/PatSysinfo/' + patId,
    method: 'delete'
  })
}
