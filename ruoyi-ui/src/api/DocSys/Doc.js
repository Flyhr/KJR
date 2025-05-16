import request from '@/utils/request'

// 查询医生信息列表
export function listDoc(query) {
  return request({
    url: '/DocSys/Doc/list',
    method: 'get',
    params: query
  })
}

// 查询医生信息详细
export function getDoc(userId) {
  return request({
    url: '/DocSys/Doc/' + userId,
    method: 'get'
  })
}

// 新增医生信息
export function addDoc(data) {
  return request({
    url: '/DocSys/Doc',
    method: 'post',
    data: data
  })
}

// 修改医生信息
export function updateDoc(data) {
  return request({
    url: '/DocSys/Doc',
    method: 'put',
    data: data
  })
}

// 删除医生信息
export function delDoc(userId) {
  return request({
    url: '/DocSys/Doc/' + userId,
    method: 'delete'
  })
}
