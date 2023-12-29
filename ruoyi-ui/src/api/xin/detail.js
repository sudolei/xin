import request from '@/utils/request'

// 查询模板详细信息列表
export function listDetail(query) {
  return request({
    url: '/xin/detail/list',
    method: 'get',
    params: query
  })
}

// 查询模板详细信息详细
export function getDetail(id) {
  return request({
    url: '/xin/detail/' + id,
    method: 'get'
  })
}

// 新增模板详细信息
export function addDetail(data) {
  return request({
    url: '/xin/detail',
    method: 'post',
    data: data
  })
}

// 修改模板详细信息
export function updateDetail(data) {
  return request({
    url: '/xin/detail',
    method: 'put',
    data: data
  })
}

// 删除模板详细信息
export function delDetail(id) {
  return request({
    url: '/xin/detail/' + id,
    method: 'delete'
  })
}
