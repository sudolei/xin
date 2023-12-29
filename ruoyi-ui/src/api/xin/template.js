import request from '@/utils/request'

// 查询模板文件列表
export function listTemplate(query) {
  return request({
    url: '/xin/template/list',
    method: 'get',
    params: query
  })
}

// 查询模板文件详细
export function getTemplate(id) {
  return request({
    url: '/xin/template/' + id,
    method: 'get'
  })
}

// 新增模板文件
export function addTemplate(data) {
  return request({
    url: '/xin/template',
    method: 'post',
    data: data
  })
}

// 修改模板文件
export function updateTemplate(data) {
  return request({
    url: '/xin/template',
    method: 'put',
    data: data
  })
}

// 删除模板文件
export function delTemplate(id) {
  return request({
    url: '/xin/template/' + id,
    method: 'delete'
  })
}
